<#import "blocks/template.ftlh" as t>
<@t.template user>
    <h1>Панель администратора</h1><br>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Email</th>
            <th scope="col">Номер телефона</th>
            <th scope="col">Активность</th>
            <th scope="col">Роли</th>
            <th scope="col">Бан</th>
            <th scope="col">Редактирование</th>
            <th scope="col">Подробная информация</th>
        </tr>
        <#list users as user>
            <tr>
                <th>${user.email}</th>
                <th>${user.phoneNumber}</th>
                <th><#if user.active>true<#else>false</#if></th>
                <th><#list user.roles as role><${role}</#list</th>
                <th><form action="user/ban/${user.id} method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" value="Бан">
                    </form>
                </th>
                <th><a href="/admin/user/edit/${user.id}">Редактирование</a></th>
                <th><a href="/user/${user.id}"> Подробная инофрмация </a></th>
            </tr>
            <#else>
            <h3>Пользователя нет</h3>
        </#list>
    </table>
</@t.template>