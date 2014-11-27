package neresources.utils;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReflectionHelper
{
    public static Map<String,String> deObfMap = new LinkedHashMap<String, String>();
    public ReflectionHelper()
    {
        deObfMap.put("numberOfBlocks", "field_76541_b");
        deObfMap.put("itemWeight", "field_76292_a");
    }

    public static boolean doesFieldExist(Class clazz, String name)
    {
        try
        {
            Field field = clazz.getDeclaredField(name);
        } catch (NoSuchFieldException e)
        {
            return false;
        }
        return true;
    }

    public static Integer getInt(Class clazz, String name, Object instance)
    {
        Integer result = null;
        try
        {
            Field getField = clazz.getDeclaredField(name);
            getField.setAccessible(true);
            result = getField.getInt(instance);
        } catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return result;
    }

    public static String getString(Class clazz, String name, Object instance)
    {
        String result = null;
        try
        {
            Field getField = clazz.getDeclaredField(name);
            getField.setAccessible(true);
            result = (String) getField.get(instance);
        } catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        if (result == null) return "";
        return result;
    }

    public static boolean getBoolean(Class clazz, String name, Object instance)
    {
        Boolean result = null;
        try
        {
            Field getField = clazz.getDeclaredField(name);
            getField.setAccessible(true);
            result = (Boolean) getField.get(instance);
        } catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        if (result == null) return false;
        return result;
    }

    public static Object getObject(Class clazz, String name, Object instance)
    {
        try
        {
            Field getField = clazz.getDeclaredField(name);
            getField.setAccessible(true);
            return getField.get(instance);
        } catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static Class findClass(String name)
    {
        try {
            return Class.forName(name);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

}
