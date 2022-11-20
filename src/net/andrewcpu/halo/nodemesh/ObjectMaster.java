package net.andrewcpu.halo.nodemesh;

import net.andrewcpu.halo.nodes.nodes.objects.*;
import net.andrewcpu.halo.nodes.nodes.objects.transform.*;
import net.andrewcpu.halo.type.ObjectType;

import java.util.List;

public class ObjectMaster extends MasterCollection<ObjectType> {
	@Override
	public Class<ObjectType> getDataType() {
		return ObjectType.class;
	}

	@Override
	public List<PrefillNodeValue> getters() {
		return List.of(
				PrefillNodeValue.of(AreSameObject.class, 0,"equal"),
				PrefillNodeValue.of(GetObjectAngularVelocity.class, 0, "getAngularVelocity"),
				PrefillNodeValue.of(GetObjectForward.class, 0, "getForward"),
				PrefillNodeValue.of(GetObjectPosition.class, 0, "getPosition"),
				PrefillNodeValue.of(GetObjectRotation.class, 0, "getRotation"),
				PrefillNodeValue.of(GetObjectUp.class, 0, "getUp"),
				PrefillNodeValue.of(GetObjectVelocity.class,0, "getVelocity"),
				PrefillNodeValue.of(GetIsValidObject.class, 0, "isValid"),
				PrefillNodeValue.of(GetObjectHealth.class,0,"getHealth"),
				PrefillNodeValue.of(GetObjectShield.class,0,"getShield"),
				PrefillNodeValue.of(GetObjectTeam.class, 0, "getTeam")
		);
	}

	@Override
	public List<PrefillNodeValue> setters() {
		return List.of(
				PrefillNodeValue.of(SetObjectAngularVelocity.class, 0, "setAngularVelocity"),
				PrefillNodeValue.of(SetObjectPosition.class, 0, "setPosition"),
				PrefillNodeValue.of(SetObjectRotation.class, 0, "setRotation"),
				PrefillNodeValue.of(SetObjectVelocity.class, 0, "setVelocity")
		);
	}

	@Override
	public List<PrefillNodeValue> functions() {
		return List.of(
				PrefillNodeValue.of(DeleteObject.class, 0, "delete"),
				PrefillNodeValue.of(DamageObject.class, 0, "damage"),
				PrefillNodeValue.of(MoveObjectToTransform.class, 0, "moveToTransform"),
				PrefillNodeValue.of(ResetObject.class, 0, "reset"),
				PrefillNodeValue.of(RotateObjectToPoint.class, 0, "rotateToPoint"),
				PrefillNodeValue.of(TranslateObjectToPoint.class, 0, "translateToPoint")
		);
	}
}
