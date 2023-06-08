import com.haulmont.cuba.core.global.UserSessionSource
import com.haulmont.cuba.core.global.AppBeans
def roles = [ 'operator_bank',  'Administrators',  'manager_salon',  'master', ]
return AppBeans.get(UserSessionSource.class).getUserSession().getRoles().any{roles.contains(it)}