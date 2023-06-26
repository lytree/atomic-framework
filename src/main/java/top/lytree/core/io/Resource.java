package top.lytree.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源加载器
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
