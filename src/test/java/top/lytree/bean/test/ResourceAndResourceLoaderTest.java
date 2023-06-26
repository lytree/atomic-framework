package top.lytree.bean.test;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Test;
import top.lytree.core.io.DefaultResourceLoader;
import top.lytree.core.io.FileSystemResource;
import top.lytree.core.io.Resource;
import top.lytree.core.io.UrlResource;
import top.lytree.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;

public class ResourceAndResourceLoaderTest {
    @Test
    public void testResourceLoader() throws Exception {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        //加载classpath下的资源
        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        System.out.println(content);
        assertThat(content, IsEqual.equalTo("hello world"));

        //加载文件系统资源
        resource = resourceLoader.getResource("src/test/resources/hello.txt");

        assertThat(resource, IsInstanceOf.instanceOf(FileSystemResource.class));
        inputStream = resource.getInputStream();
        content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        System.out.println(content);
        assertThat(content, IsEqual.equalTo("hello world"));

        //加载url资源
        resource = resourceLoader.getResource("https://github.com/DerekYRC/mini-spring/blob/main/README.md");
        assertThat(resource, IsInstanceOf.instanceOf(UrlResource.class));
        inputStream = resource.getInputStream();
        content = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        System.out.println(content);
    }
}
