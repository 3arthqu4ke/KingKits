package com.comphenix.attributes;

import net.minecraft.nbt.*;

import java.lang.reflect.InvocationTargetException;

// TODO: do this with reflection so we do not need to depend on craft bukkit?
@SuppressWarnings("unused")
public class NewNBTFactory {
    public static final byte TAG_END = 0;
    public static final byte TAG_BYTE = 1;
    public static final byte TAG_SHORT = 2;
    public static final byte TAG_INT = 3;
    public static final byte TAG_LONG = 4;
    public static final byte TAG_FLOAT = 5;
    public static final byte TAG_DOUBLE = 6;
    public static final byte TAG_BYTE_ARRAY = 7;
    public static final byte TAG_STRING = 8;
    public static final byte TAG_LIST = 9;
    public static final byte TAG_COMPOUND = 10;
    public static final byte TAG_INT_ARRAY = 11;
    public static final byte TAG_LONG_ARRAY = 12;

    public static Object createTag(byte by)
        throws NoSuchMethodException,
               InvocationTargetException, InstantiationException,
               IllegalAccessException {
        switch (by) {
            case TAG_END: {
                return NBTTagEnd.b;
            }
            case TAG_BYTE: {
                return NBTTagByte.a((byte) 0);
            }
            case TAG_SHORT: {
                return NBTTagShort.a((short) 0);
            }
            case TAG_INT: {
                return NBTTagInt.a(0);
            }
            case TAG_LONG: {
                return NBTTagLong.a(0L);
            }
            case TAG_FLOAT: {
                return NBTTagFloat.a(0.0f);
            }
            case TAG_DOUBLE: {
                return NBTTagDouble.a(0.0);
            }
            case TAG_BYTE_ARRAY: {
                return new NBTTagByteArray(new byte[0]);
            }
            case TAG_STRING: {
                return NBTTagString.a("");
            }
            case TAG_LIST: {
                return new NBTTagList();
            }
            case TAG_COMPOUND: {
                return new NBTTagCompound();
            }
            case TAG_INT_ARRAY: {
                return new NBTTagIntArray(new int[0]);
            }
            case TAG_LONG_ARRAY: {
                // we need to use reflection here or compilation fails because of the FastUtils import
                //noinspection RedundantCast
                return NBTTagLongArray.class.getDeclaredConstructor(long[].class).newInstance((Object) new long[0]);
            }
        }

        return null;
    }

}
