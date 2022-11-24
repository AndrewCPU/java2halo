package net.andrewcpu.script.highlevel;

import net.andrewcpu.script.highlevel.interfaces.HaloConstant;
import net.andrewcpu.script.highlevel.types.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.lang.String;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllConstants {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        File file = new File("C:\\Users\\stein\\Documents\\GitHub\\java2halo\\src\\net\\andrewcpu\\halo\\nodes\\nodes\\variables\\advanced");
        File[] files = file.listFiles();
        System.out.println(Arrays.stream(files).filter(f -> f.getName().startsWith("Get")).map(f -> f.getName().substring(0, f.getName().indexOf(".")) + ".class").collect(Collectors.joining(", ")));
    }
}
