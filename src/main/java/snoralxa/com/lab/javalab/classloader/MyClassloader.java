package snoralxa.com.lab.javalab.classloader;

import java.io.*;

/**
 * @Author: 余子毅
 * @Date: 2021/7/2 1:13
 */
public class MyClassloader extends ClassLoader {

    private String path;

    private String classloaderName;

    public MyClassloader(String path, String classloaderName) {
        this.path = path;
        this.classloaderName = classloaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classByte = getClassByte(name);
        return defineClass(name, classByte, 0, classByte.length);
    }

    private byte[] getClassByte(String name) {
        name = path + name.replaceAll("\\.", "\\\\") + ".class";
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(new File(name));
            outputStream = new ByteArrayOutputStream();
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert inputStream != null;
                inputStream.close();
                assert outputStream != null;
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputStream.toByteArray();
    }


}
