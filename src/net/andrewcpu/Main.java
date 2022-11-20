package net.andrewcpu;

import net.andrewcpu.halo.nodemesh.*;
import net.andrewcpu.halo.nodes.DataNode;
import net.andrewcpu.halo.nodes.IONode;
import net.andrewcpu.halo.nodes.InputOnlyNode;
import net.andrewcpu.halo.type.DataType;
import net.andrewcpu.halo.type.ExecutionThreadType;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

	public static void printFunctionFromNode(Object nodea) {
		PrefillNodeValue node = (PrefillNodeValue)nodea;
		DataType[] parameters = node.getInputNodes();
		String textVersion = Arrays.stream(parameters).map(i -> i.getClass().getSimpleName() + " " + i.getName()).collect(Collectors.joining(", "));
		String outputTypes = Arrays.stream(node.getNode().getOutputs()).map(i -> i.getClass().getSimpleName() + " " + i.getName()).collect(Collectors.joining(", "));

		String type;
		if(node.getNode() instanceof IONode) {
			type = "PASSTHROUGH";
		}
		else if(node.getNode().canCarryLogic()) {
			type = "CTRL-FLOW";
		}
		else if(node.getNode() instanceof DataNode) {
			type = "GET";
		}
		else if(node.getNode() instanceof InputOnlyNode) {
			type = "TERM";
		}
		else{
			type = "?";
		}
		boolean isAbstract = true;
		String returnType;
		if(node.getNode().getOutputs().length > 1) {
			returnType = "MultiResponseType";
			isAbstract = false;
		}
		else if(node.getNode().getOutputs().length == 1){
			returnType = node.getNode().getOutputs()[0].getClass().getSimpleName();
		}
		else{
			returnType = "ExecutionThreadType";
		}
		String cmdline = "";
		if(!isAbstract) {
			cmdline += "{" + System.lineSeparator();
			cmdline += "    return new MultiResponseType(" + Arrays.stream(node.getNode().getOutputs()).map(typeX -> "new NamedResult(\"" + typeX.getName() + "\", " + typeX.getClass().getSimpleName() + ".class)").collect(Collectors.joining( ", "));
			cmdline += ");" + System.lineSeparator();
			cmdline +="}";
		}


		System.out.printf("public " + (isAbstract ? "abstract " : "") + returnType + " " + node.getName() + "(" + textVersion + ")" + (isAbstract ? ";" : cmdline) + "\n");
	}
	public static void main(String[] args) {
		PlayerMaster playerMaster = new PlayerMaster();
		TeamMaster teamMaster = new TeamMaster();
		ObjectListMaster objectListMaster = new ObjectListMaster();
		ObjectMaster objectMaster = new ObjectMaster();
		VehicleMaster vehicleMaster = new VehicleMaster();
		WeaponMaster weaponMaster = new WeaponMaster();
		VectorMaster vectorMaster = new VectorMaster();
		EquipmentMaster equipmentMaster = new EquipmentMaster();
		GameMaster gameMaster = new GameMaster();

//		printMaster(teamMaster);
		printMaster(playerMaster);
//		printMaster(objectListMaster);
//		printMaster(objectMaster);
//		printMaster(vehicleMaster);
//		printMaster(weaponMaster);
//		printMaster(vectorMaster);
//		printMaster(equipmentMaster);
//		printMaster(gameMaster);
	}

	public static void printMaster(MasterCollection collection) {
		System.out.println();
		System.out.println(collection.getClass().getSimpleName());
		for(Object node : collection.functions()) {
			printFunctionFromNode(node);
		}
		for(Object node : collection.getters()) {
			printFunctionFromNode(node);
		}
		for(Object node : collection.setters()) {
			printFunctionFromNode(node);
		}
	}

	public static void handleDirectory(File file) {
		String output = "List " + file.getName() + " = List.of(";
		File[] subfiles = file.listFiles();
		output += Arrays.stream(subfiles).filter(sub -> !sub.isDirectory()).map(sub -> sub.getName().substring(0,sub.getName().indexOf(".")) + ".class").collect(Collectors.joining(", ")) + ");";
		Arrays.stream(subfiles).filter(sub -> sub.isDirectory()).forEach(Main::handleDirectory);
		System.out.println(output);
	}
}
