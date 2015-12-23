package com.exemplos.assist;

import com.exemplos.assist.version;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Main {

    public static void main(String[] args) throws Exception {

        ClassPool objClassPool = ClassPool.getDefault();

        //Ir buscar a classe
        CtClass objCtClass = objClassPool.get("com.exemplos.assist.Client");

        //Ir buscar o metodo
        CtMethod objCtMethod = objCtClass.getDeclaredMethod("sample");

        //Mudar o metodo para retornar a versao
        objCtMethod.setBody("{ return \""+((version) objCtMethod.getAnnotation(version.class)).value()+"\"; }");

        Class objClass = objCtClass.toClass();

        Client c = (Client)objClass.newInstance();

        System.out.println("Versão: "+c.sample());
    }

}


