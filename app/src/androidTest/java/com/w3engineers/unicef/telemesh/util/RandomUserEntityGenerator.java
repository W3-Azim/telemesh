package com.w3engineers.unicef.telemesh.util;

import com.github.javafaker.Faker;
import com.w3engineers.unicef.telemesh.data.local.usertable.UserEntity;

/**
 * ============================================================================
 * Copyright (C) 2019 W3 Engineers Ltd - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * <br>----------------------------------------------------------------------------
 * <br>Created by: Ahmed Mohmmad Ullah (Azim) on [2019-01-31 at 11:20 AM].
 * <br>----------------------------------------------------------------------------
 * <br>Project: telemesh.
 * <br>Code Responsibility: <Purpose of code>
 * <br>----------------------------------------------------------------------------
 * <br>Edited by :
 * <br>1. <First Editor> on [2019-01-31 at 11:20 AM].
 * <br>2. <Second Editor>
 * <br>----------------------------------------------------------------------------
 * <br>Reviewed by :
 * <br>1. <First Reviewer> on [2019-01-31 at 11:20 AM].
 * <br>2. <Second Reviewer>
 * <br>============================================================================
 **/

/**
 * Descendant of {@link RandomGenerator}. Particularly generates {@link UserEntity}.
 * <br/>Put names properly
 * with a library called <a href="https://github.com/DiUS/java-faker">Java Faker</a>
 */
public class RandomUserEntityGenerator extends RandomGenerator {

    @Override
    public <T> T createAndFill(Class<T> clazz) throws Exception {
        UserEntity userEntity = (UserEntity) super.createAndFill(clazz);

        Faker faker = new Faker();

        userEntity.setUserFirstName(faker.name().firstName());
        userEntity.setUserLastName(faker.name().lastName());

        @SuppressWarnings("unchecked")
        T t = (T) userEntity;
        return t;
    }
}
