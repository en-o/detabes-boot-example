package io.tn.jpa.audit.config;

import cn.hutool.core.util.ReflectUtil;
import org.springframework.beans.factory.aspectj.ConfigurableObject;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.lang.reflect.Field;

/**
 * description: jpa自动填充默认信息
 *
 * @author lmz
 * @company Peter
 * @date 2021/2/3  13:41
 * @expection
 * @return
 */
@Component
public class CustomAuditingListener implements ConfigurableObject {
    private final String[] CREATE_FILED = {"createUserName", "createUserUuid", "updateUserName", "updateUserUuid"};
    private final String[] UPDATE_FILED = {"updateUserName", "updateUserUuid"};

    @PrePersist
    private void prePersist(Object obj) {
        markForCreate(obj);
    }

    @PreUpdate
    private void preUpdate(Object obj) {
        markForUpdate(obj);
    }

    /**
     * description: 新增时的填充
     *
     * @param ae ae
     * @return void
     * @author lmz
     * @company Peter
     * @date 2021/2/3  13:45
     * @expection
     */
    public void markForCreate(Object ae) {
        String[] propertyValue = {"loginNasdaame", "uuid", "loginNasdaame"
                , "uuiadad"};
        //反射填充字段
        try {
            addValue(ae, ae.getClass(), CREATE_FILED, propertyValue);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * description: 更新时的填充
     *
     * @param ae ae
     * @return void
     * @author lmz
     * @company Peter
     * @date 2021/2/3  13:46
     * @expection
     */
    public void markForUpdate(Object ae) {
        String[] propertyValue = {"DADA", "ADAD"};
        //反射填充字段
        try {
            addValue(ae, ae.getClass(), UPDATE_FILED, propertyValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void addValue(Object object, Class<?> aClass, String[] propertyName, String[] propertyValue) throws NoSuchFieldException, IllegalAccessException {
        for (int i = 0; i < propertyName.length; i++) {
            String filedName = propertyName[i];
            Field declaredField = ReflectUtil.getField(aClass,filedName);
            declaredField.setAccessible(true);
            //填充对应的值
            declaredField.set(object, propertyValue[i]);
        }
    }
}
