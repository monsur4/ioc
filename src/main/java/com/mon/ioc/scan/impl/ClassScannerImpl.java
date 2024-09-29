package com.mon.ioc.scan.impl;

import com.mon.ioc.scan.ClassDefinition;
import com.mon.ioc.scan.ClassScanner;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * this class scans and collects all classes in the project (based on some criteria)
 */
public class ClassScannerImpl implements ClassScanner {

    final Set<ClassDefinition> classDefinitions;

    public Set<ClassDefinition> getClassDefinitions() {
        return classDefinitions;
    }

    public ClassScannerImpl() {
        classDefinitions = new HashSet<>();
    }

    @Override
    public void scan(Class<?> startUpClass) {
        String directory = startUpClass.getProtectionDomain().getCodeSource().getLocation().getFile();
        File file = new File(directory);

        System.out.println("directory = " + directory);

        scanDir(file, "");
    }

    private void scanDir(File file, String rootPackageName){
        File[] files = file.listFiles();
        if(files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    String pkg = f.getName();
                    scanDir(f, rootPackageName + pkg + ".");
                }else{
                    String leafFile = rootPackageName + f.getName();
                    ClassDefinition classDefinition = new ClassDefinition()
                            .setType(ClassDefinition.TYPE.SINGLETON)
                            .setFullClassName(leafFile);
                    classDefinitions.add(classDefinition);
                }
            }
        }
    }
}
