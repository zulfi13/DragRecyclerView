package com.wonshinhyo.dragrecyclerview.sample.realm;

import android.app.Application;

import com.wonshinhyo.dragrecyclerview.sample.realm.item.Dummy;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

/**
 * Created by shinhyo.
 */

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        Realm.setDefaultConfiguration(getRealmConfiguration());
    }

    private RealmConfiguration getRealmConfiguration() {

        return new RealmConfiguration.Builder()
                .name("sample.rm")
                .initialData(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        RealmList<Dummy> dummies = new RealmList<>();
                        for (int i = 0; i < 50; i++) {
                            dummies.add(new Dummy(i, i, i));
                        }
                        realm.copyToRealm(dummies);
                    }
                })
                .build();
    }
}
