package com.baoyz.dribble;

import android.content.Intent;
import android.os.Bundle;

import com.baoyz.dribble.fragment.FeedFragment;

import it.neokree.materialnavigationdrawer.MaterialAccount;
import it.neokree.materialnavigationdrawer.MaterialAccountListener;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.MaterialSection;

public class MainActivity extends MaterialNavigationDrawer implements MaterialAccountListener {

    @Override
    public void init(Bundle bundle) {

        MaterialAccount account = new MaterialAccount(getResources(), "Baoyz", "baoyz94@gmail.com", R.drawable.avatar, R.drawable.mat3);
        this.addAccount(account);

        this.setAccountListener(this);

        Intent i = new Intent(this, SettingsActivity.class);
        MaterialSection settingsSection = this.newSection("Settings", this.getResources().getDrawable(R.drawable.ic_settings_black_48dp), i);

        this.addSection(newSection("Popular", FeedFragment.newInstance("")));
        this.addSection(newSection("Animated", FeedFragment.newInstance("animated")));
        this.addSection(newSection("Debuts", FeedFragment.newInstance("debuts")));
        this.addSection(newSection("Playoffs", FeedFragment.newInstance("playoffs")));
        this.addSection(newSection("Rebounds", FeedFragment.newInstance("rebounds")));
        this.addSection(newSection("Teams", FeedFragment.newInstance("teams")));
        this.addBottomSection(settingsSection);

        this.setBackPattern(MaterialNavigationDrawer.BACKPATTERN_BACK_TO_FIRST);

    }

    @Override
    public void onAccountOpening(MaterialAccount materialAccount) {

    }

    @Override
    public void onChangeAccount(MaterialAccount materialAccount) {

    }
}
