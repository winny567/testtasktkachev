import com.haulmont.cuba.core.global.AppBeans
import com.haulmont.cuba.core.global.UserSessionSource

def roles = [ 'Administrators',  'manager_salon', ]
return AppBeans.get(UserSessionSource.class).getUserSession().getRoles().any{roles.contains(it)}