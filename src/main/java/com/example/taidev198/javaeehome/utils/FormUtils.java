package com.example.taidev198.javaeehome.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class FormUtils {


    public static <T> T toModel(Class<T> tClass, HttpServletRequest request) {

        T object =null;
        try {
            object = tClass.newInstance();
            BeanUtils.populate(object, request.getParameterMap());//mapping request's params to key-value pairs
            return object;
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
