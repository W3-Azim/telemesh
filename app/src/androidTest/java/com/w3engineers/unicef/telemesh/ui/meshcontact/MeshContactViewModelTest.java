package com.w3engineers.unicef.telemesh.ui.meshcontact;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.support.test.runner.AndroidJUnit4;

import com.w3engineers.unicef.telemesh.data.local.usertable.UserEntity;
import com.w3engineers.unicef.telemesh.data.provider.ServiceLocator;
import com.w3engineers.unicef.telemesh.util.LiveDataTestUtil;
import com.w3engineers.unicef.telemesh.util.RandomUserEntityGenerator;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * ============================================================================
 * Copyright (C) 2019 W3 Engineers Ltd - All Rights Reserved.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * <br>----------------------------------------------------------------------------
 * <br>Created by: Ahmed Mohmmad Ullah (Azim) on [2019-01-30 at 3:58 PM].
 * <br>----------------------------------------------------------------------------
 * <br>Project: telemesh.
 * <br>Code Responsibility: <Purpose of code>
 * <br>----------------------------------------------------------------------------
 * <br>Edited by :
 * <br>1. <First Editor> on [2019-01-30 at 3:58 PM].
 * <br>2. <Second Editor>
 * <br>----------------------------------------------------------------------------
 * <br>Reviewed by :
 * <br>1. <First Reviewer> on [2019-01-30 at 3:58 PM].
 * <br>2. <Second Reviewer>
 * <br>============================================================================
 **/
@RunWith(AndroidJUnit4.class)
public class MeshContactViewModelTest {

    private final String EMPTY_SEARCH_TEXT = "", SMALL_SEARCH_TEXT = "or", CAPITAL_SEARCH_TEXT = "OR",
    SMALL_CAPITAL_SEARCH_TEXT = "Or";

    private CompositeDisposable mCompositeDisposable;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();


    private List<UserEntity> mUserEntities;
    private MeshContactViewModel mMeshContactViewModel;

    @Before
    public void init() {
        try {

            RandomUserEntityGenerator randomUserEntityGenerator = new RandomUserEntityGenerator();

            UserEntity userEntity1 = randomUserEntityGenerator.createAndFill(UserEntity.class);
            UserEntity userEntity2 = randomUserEntityGenerator.createAndFill(UserEntity.class);
            UserEntity userEntity3 = randomUserEntityGenerator.createAndFill(UserEntity.class);
            UserEntity userEntity4 = randomUserEntityGenerator.createAndFill(UserEntity.class);
            UserEntity userEntity5 = randomUserEntityGenerator.createAndFill(UserEntity.class);

            mUserEntities = new ArrayList<>(Arrays.asList(userEntity1, userEntity2, userEntity3,
                    userEntity4, userEntity5));
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMeshContactViewModel = ServiceLocator.getInstance().getMeshContactViewModel();
        mCompositeDisposable = new CompositeDisposable();
    }

    @After
    public void destroy() {
        mCompositeDisposable.dispose();
    }

    @Test
    public void meshContactViewModelSearch_smallLetter_retrieveUsers() throws InterruptedException {

        //arrange
        int itemCount = getItemCountInList(mUserEntities, SMALL_SEARCH_TEXT);
        LiveData<List<UserEntity>> listLiveData = mMeshContactViewModel.getGetFilteredList();

        //action
        mMeshContactViewModel.startSearch(SMALL_SEARCH_TEXT, mUserEntities);

        //assertion
        List<UserEntity> userEntityList = LiveDataTestUtil.getValue(listLiveData);
        assertThat(userEntityList.size(), is(itemCount));
    }

    @Test
    public void meshContactViewModelSearch_capitalLetter_retrieveUsers() throws InterruptedException {

        //arrange
        int itemCount = getItemCountInList(mUserEntities, CAPITAL_SEARCH_TEXT);
        LiveData<List<UserEntity>> listLiveData = mMeshContactViewModel.getGetFilteredList();

        //action
        mMeshContactViewModel.startSearch(CAPITAL_SEARCH_TEXT, mUserEntities);

        //assertion
        List<UserEntity> userEntityList = LiveDataTestUtil.getValue(listLiveData);
        assertThat(userEntityList.size(), is(itemCount));
    }

    @Test
    public void meshContactViewModelSearch_smallCapitalLetter_retrieveUsers() throws InterruptedException {

        //arrange
        int itemCount = getItemCountInList(mUserEntities, SMALL_CAPITAL_SEARCH_TEXT);
        LiveData<List<UserEntity>> listLiveData = mMeshContactViewModel.getGetFilteredList();

        //action
        mMeshContactViewModel.startSearch(SMALL_CAPITAL_SEARCH_TEXT, mUserEntities);

        //assertion
        List<UserEntity> userEntityList = LiveDataTestUtil.getValue(listLiveData);
        assertThat(userEntityList.size(), is(itemCount));
    }

    @Test
    public void meshContactViewModelSearch_emptyText_retrieveAllUsers() throws InterruptedException {

        //arrange
        LiveData<List<UserEntity>> listLiveData = mMeshContactViewModel.getGetFilteredList();

        //action
        mMeshContactViewModel.startSearch(EMPTY_SEARCH_TEXT, mUserEntities);

        //assertion
        List<UserEntity> userEntityList = LiveDataTestUtil.getValue(listLiveData);
        assertThat(userEntityList.size(), is(mUserEntities.size()));
    }

    //This count can be implemented many ways. I prefer so for easy coding.
    //Our objective here is to count item rather the frequency.
    private int getItemCountInList(List<UserEntity> userEntities, String text) {

        final int[] smallLetterActualUsercount = {0};

        mCompositeDisposable.add(Observable.fromIterable(userEntities).filter(userEntity ->
                userEntity.getFullName().contains(text) ).subscribe(userEntity ->
                smallLetterActualUsercount[0]++));

        return smallLetterActualUsercount[0];
    }
}