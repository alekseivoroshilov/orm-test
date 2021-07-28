package dbService.dao;

import dbService.dataSets.UsersDataSet;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public long getUserId(String name) throws HibernateException {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UsersDataSet> criteria = builder.createQuery(UsersDataSet.class);
        Root<UsersDataSet> usersDataSetRoot = criteria.from(UsersDataSet.class);
        //return ((UsersDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
        criteria.select(usersDataSetRoot).where(usersDataSetRoot.get("name").in(name));
        Query<UsersDataSet> query = session.createQuery(criteria);
        long id = -1;
        try {
            id = query.getSingleResult().getId();
        }
        catch (NoResultException e){
        }

        System.out.println("User id: " + id);
        return id;
    }

    public long insertUser(String name, String password) throws HibernateException {
        return (Long) session.save(new UsersDataSet(name, password));
    }
}
