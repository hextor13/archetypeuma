package org.archetypeUma.utils;

/*
 * Copyright (c) 2010, Oracle. All rights reserved. Redistribution and use in
 * source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met: * Redistributions of source code must
 * retain the above copyright notice, this list of conditions and the following
 * disclaimer. * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution. *
 * Neither the name of Oracle nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior
 * written permission. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND
 * CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

/**
 * @author mbohm
 */
public class JsfUtils {

    public static SelectItem[] getSelectItems(List<?> entities,
            boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }

    public static List<SelectItem> convertListItem(final List lista,
            final String value, final String label) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        final List<SelectItem> listaItems = new ArrayList<SelectItem>();
        if (lista != null) {
            for (Object objeto : lista) {
                final SelectItem i = new SelectItem();

                final String idValue = getBeanValue(objeto, value);
                i.setValue(idValue);

                final String labelValue = getBeanValue(objeto, label);
                i.setLabel(labelValue);

                listaItems.add(i);
            }
        }
        return listaItems;
    }

    public static String getBeanValue(Object objeto, String propertyLabel)
            throws SecurityException, NoSuchMethodException,
            IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        final Class[] vacio = new Class[0];
        final Object[] vacioObjetos = new Object[0];

        final Method metodo = objeto.getClass().getMethod(
                "get" + primeraLetraMayusculas(propertyLabel), vacio);
        final Object resultadoMetodo = metodo.invoke(objeto, vacioObjetos);

        String value = null;
        if (resultadoMetodo != null) {
            value = resultadoMetodo.toString();
        }

        return value;
    }

    /**
     * Pone la primera letra de un String a mayusculas.
     * 
     * @param entrada
     *            String que se quiere procesar.
     * @return String con la primera letra en mayusculas.
     */
    public static String primeraLetraMayusculas(final String entrada) {
        String sufijo, prefijo;
        prefijo = entrada.substring(0, 1);
        prefijo = prefijo.toUpperCase();
        sufijo = entrada.substring(1);
        return prefijo + sufijo;
    }

    public static void ensureAddErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }

    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext()
                .getRequestParameterMap().get(key);
    }

    public static Object getObjectFromRequestParameter(
            String requestParameterName, Converter converter,
            UIComponent component) {
        String theId = getRequestParameter(requestParameterName);
        return converter.getAsObject(FacesContext.getCurrentInstance(),
                component, theId);
    }

    public static <T> Collection<T> arrayToCollection(T[] arr) {
        if (arr == null) {
            return new ArrayList<T>();
        }
        return Arrays.asList(arr);
    }

    public static Object[] collectionToArray(Collection<?> c) {
        if (c == null) {
            return new Object[0];
        }
        return c.toArray();
    }

    public static String getAsConvertedString(Object object, Converter converter) {
        return converter.getAsString(FacesContext.getCurrentInstance(), null,
                object);
    }

    public static String getAsString(Object object) {
        if (object instanceof Collection<?>) {
            Collection<?> collection = (Collection<?>) object;
            if (collection.size() == 0) {
                return "(No Items)";
            }
            StringBuffer sb = new StringBuffer();
            int i = 0;
            for (Object item : collection) {
                if (i > 0) {
                    sb.append("<br />");
                }
                sb.append(item);
                i++;
            }
            return sb.toString();
        }
        return String.valueOf(object);
    }
}
