package com.coulcod.development_tools.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;


import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListUtil {

    private static final String TAG = "ListUtil";

    @Nullable
    public static <T> T getLast(@Nullable List<T> list) {
        T result = null;
        if(!isEmpty(list)){
            result = list.get(list.size() - 1);
        }
        return result;
    }

    @Nullable
    public static <T> T getItemFromEnd(List<T> list, int items) {
        T result = null;
        if (list.size() > items) {
            result = list.get(list.size() - 1 - items);
        }
        return result;
    }

    public static <T> void removeLast(List<T> list){
        list.remove(list.size() - 1);
    }

    public static <T> boolean isEmpty(List<T> list){
        return list == null || list.size() == 0;
    }

    public static boolean isSizeMoreThan(List list, int estimatedSize) {
        return list != null && list.size() >= estimatedSize;
    }

    public static <T> void removeAllBut(List<T> list, T save){
        for(int i=0; i<list.size(); i++) {
            T item = list.get(i);
            if(!item.equals(save)){
                list.remove(i);
                i--;
            }
        }
    }

    public static <T> boolean equals(List<T> original, List<T> other){

        if(original.size() != other.size()){
            return false;
        }

        for(int i=0; i<original.size(); i++) {

            if(!original.get(i).equals(other.get(i))){
                return false;
            }

        }

        return true;
    }

    public static <T> boolean isLast(List<T> list, T item) {

        if (list.get(list.size() - 1) == item) {
            return true;
        }

        return false;

    }

    @NonNull
    public static <T extends Cloneable> List<T> clone(@Nullable List<T> list) {
        ArrayList<T> result = new ArrayList<>(list != null ? list.size() : 0);
        if (list != null) {
            Class<?> classT = null;
            for (T m : list) {
                if (classT == null) {
                    classT = m.getClass();
                }
                try {
                    Object cloned = classT.getMethod("clone").invoke(m);
                    m.getClass();
                    if (classT.isInstance(cloned)) {
                        result.add((T) cloned);
                    }
                } catch (NoSuchMethodException e) {
                    Log.e(TAG, "clone: ", e);
                } catch (IllegalAccessException e) {
                    Log.e(TAG, "clone: ", e);
                } catch (InvocationTargetException e) {
                    Log.e(TAG, "clone: ", e);
                }
            }
        }
        return result;
    }

    @Nullable
    public static<T> T getItem(@Nullable List<T> list, int position) {
        T result = null;
        if (list != null) {
            if (list.size() > position && position >= 0) {
                result = list.get(position);
            }
        }
        return result;
    }

    public static<T> ArrayList<T> toArrayList(Collection<T> collection) {
        ArrayList<T> result;
        if (collection instanceof ArrayList) {
            result = (ArrayList<T>) collection;
        } else {
            result = new ArrayList<>();
            for (T item : collection) {
                result.add(item);
            }
        }
        return result;
    }

    public static<T> void clear(@Nullable List<T> list) {
        if (!isEmpty(list)) list.clear();
    }

    public static<T> T getFirst(@Nullable List<T> list) {
        T result = null;
        if (!isEmpty(list)) result = list.get(0);
        return result;
    }

    public static<T> List<T> asList(T[] items) {
        List<T> result = new ArrayList<>();
        if (items != null) {
            Collections.addAll(result, items);
        }
        return result;
    }

    @SafeVarargs
    public static<T> void addToList(@Nullable List<T> l, @Nullable List<T> ... additionals) {
        if (l != null && additionals != null) {
            for (List<T> list : additionals) {
                l.addAll(list);
            }
        }
    }

    @SafeVarargs
    @NonNull
    public static<T> List<T> getSum(@Nullable List<T> ... lists) {
        List<T> result = new ArrayList<>();
        if (lists != null) {
            for (List<T> l : lists) {
                result.addAll(l);
            }
        }
        return result;
    }

    /**
     * Calculate position of object if List
     * @param list list of object where looking position of target object, if value is null result be -1
     * @param object object to find in list, if value is null result be -1
     * @param <T> List inner class type
     * @return object position in list, if object not consist in list return -1.
     */
    public static<T> int getPosition(@Nullable List<T> list, @Nullable T object) {
        int position = -1;
        if (list != null && object != null) {
            for (int i = 0; i < list.size(); i++) {
                if (object.equals(list.get(i))) {
                    position = i;
                    break;
                }
            }
        }
        return position;
    }

    public static<T> boolean isContains(@Nullable List<T> list, @Nullable T item) {
        boolean result = false;
        if (list != null && item != null) {
            for (T i : list) {
                if (item.equals(i)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public static<T> void replace(@Nullable List<T> list, @Nullable T removedValue, @Nullable T addedValue) {
        if (list != null && removedValue != null) {
            for (int i=0; i<list.size(); i++) {
                if (removedValue.equals(list.get(i))) {
                    list.remove(i);
                    if (addedValue != null) {
                        list.add(i, addedValue);
                    }
                    break;
                }
            }
        }
    }

    public static<T> void removeItem(List<T> list, T item) {
        for (int i=0; i<list.size(); i++) {
            if (item.equals(list.get(i))) {
                list.remove(i);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    @SafeVarargs
    public static<T> T[] arrayFrom(T item, T ... items) {
        T[] result = (T[]) Array.newInstance(item.getClass(), items.length + 1);
        result[0] = item;
        for (int i=0; i<items.length; i++) {
            result[i+1] = items[i];
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static void addUnckecked(List messages, Collection additional) {
        messages.addAll(additional);
    }

    @NonNull
    public static<T> List<T> subList(
            @Nullable List<T> source,
            int positionFrom,
            int positionTo
    ) {
        List<T> result = new ArrayList<>();
        if (source != null && positionFrom < source.size()) {
            for (int i=positionFrom; i<positionTo && i<source.size(); i++) {
                result.add(source.get(i));
            }
        }
        return result;
    }
}
