package com.example.pc.footscore.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pc.footscore.Controllers.Fragments.FixturesFragment;
import com.example.pc.footscore.Controllers.Fragments.FuturMatchesFragment;
import com.example.pc.footscore.Controllers.Fragments.Head2HeadFragment;
import com.example.pc.footscore.Controllers.Fragments.LeagueTabFragment;
import com.example.pc.footscore.Controllers.Fragments.PlayerFragment;
import com.example.pc.footscore.Controllers.Fragments.TeamFragment;

/**
 * Created by pc on 08/05/2018.
 */

public class TeamDetailAdapter extends FragmentPagerAdapter {
    private int[] colors;


    public TeamDetailAdapter(FragmentManager mgr, int[] colors) {
        super(mgr);
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return (3);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return (PlayerFragment.newInstance(position, this.colors[position]));
            case 1:
                return (FuturMatchesFragment.newInstance(position, this.colors[position]));
            case 2:
                return (Head2HeadFragment.newInstance(position, this.colors[position]));
        }
        return null;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return ("Joueurs");
            case 1:
                return ("MatchesAvenir");
            case 2:
                return ("TeteAtete");
        }
        return null;


    }

}
