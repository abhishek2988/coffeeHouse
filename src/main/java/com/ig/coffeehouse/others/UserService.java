package com.riskblock.theinstitutes.service.impl;


import com.riskblock.theinstitutes.model.UsersModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.exception.ConstraintViolationException;

import java.util.Iterator;
import java.util.List;

public class UserService {
    private static Logger logger = LogManager.getLogger(UserService.class);
    private SessionFactory factory;

    public UserService() {

        try {
            factory = new AnnotationConfiguration()
                    .configure()
                    .addAnnotatedClass(UsersModel.class)
                    .buildSessionFactory();
        } catch (Exception ex) {
            logger.error("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Integer setUser(String user, String password, String memberFirm, String policyNo, String userType, String producerName) {
        Session session = factory.openSession();
        Transaction transaction = null;
        Integer memberID;

        try {
            transaction = session.beginTransaction();
            UsersModel membersModel = new UsersModel();
            membersModel.setUser(user);
            membersModel.setPassword(password);
            membersModel.setMemberFirm(memberFirm);
            membersModel.setPolicyNo(policyNo);
            membersModel.setUserType(userType);
            membersModel.setProducerName(producerName);
            memberID = (Integer) session.save(membersModel);
            transaction.commit();
        } catch (ConstraintViolationException ex) {
            if (transaction != null) transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return memberID;
    }

    public UsersModel getUserDetails(String user) {
        Session session = factory.openSession();
        Transaction transaction = null;
        UsersModel membersModel = new UsersModel();
        try {
            transaction = session.beginTransaction();
            String hql = "from UsersModel UM where UM.user = '" + user + "'";
            Query query = session.createQuery(hql);
            List userList = query.list();
            for (Iterator iterator = userList.iterator(); iterator.hasNext(); ) {
                membersModel = (UsersModel) iterator.next();
            }
            transaction.commit();
        } catch (HibernateException ex) {
            if (transaction != null) transaction.rollback();
            throw ex;
        } finally {
            session.close();
        }
        return membersModel;
    }
}