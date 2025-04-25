import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.xzit.mapper.EmpMapper;
import com.xzit.model.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.util.List;

public class TestMybatisPlus {
    @Test
    public void TestList() throws IOException {
        SqlSessionFactoryBuilder builder = new MybatisSqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession session = sqlSessionFactory.openSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        List<Emp> list = mapper.selectList(null);
        list.forEach(System.out::println);
    }
    @Test
    public void TestInsert() throws IOException{
        SqlSessionFactoryBuilder builder = new MybatisSqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession session = sqlSessionFactory.openSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        Emp emp = new Emp(3,"王五","武汉","天津",41);
        mapper.insert(emp);
    }
    @Test
    public void TestDelete() throws IOException{
        SqlSessionFactoryBuilder builder = new MybatisSqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession session = sqlSessionFactory.openSession();
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        mapper.deleteById(3);
    }

}
