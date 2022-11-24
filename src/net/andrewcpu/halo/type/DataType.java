package net.andrewcpu.halo.type;

import javax.xml.crypto.Data;
import java.lang.reflect.InvocationTargetException;

public abstract class DataType {
    private String name;

    public DataType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Class<? extends DataType> getByName(String name) {
        for (Class<? extends DataType> types : DataType.values()) {
            if (types.getSimpleName().equalsIgnoreCase(name)){
                return types;
            }
        }
        return null;
    }

    public static DataType nameToInstance(String name) {
        Class<? extends DataType> className = getByName(name);
        try {
            return (((DataType) className.getConstructors()[0].newInstance("name")));
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static Class<? extends DataType>[] values() {
        return new Class[]{
                AreaMonitorType.class,
                ArrayType.class,
                AudioZoneEffectType.class,
                BooleanType.class,
                BotDifficultyType.class,
                BotPlayerType.class,
                DeathContextType.class,
                EquipmentType.class,
                EquipmentTypeType.class,
                ExecutionThreadType.class,
                GrenadeTypeType.class,
                IdentifierType.class,
                MovementCurveType.class,
                NavMarkerType.class,
                NumberType.class,
                ObjectsType.class,
                ObjectType.class,
                PlayersType.class,
                PlayerType.class,
                RespawnMessageType.class,
                ScopeType.class,
                StringType.class,
                TeamType.class,
                TraitsType.class,
                TraitType.class,
                UIMessageTemplateType.class,
                UIMessageType.class,
                VectorType.class,
                VehicleType.class,
                VehicleTypeType.class,
                WeaponAdditionMethodType.class,
                WeaponConfigurationType.class,
                WeaponType.class,
                WeaponTypeType.class,
                GameType.class,
                VariableType.class
        };
    }
}
