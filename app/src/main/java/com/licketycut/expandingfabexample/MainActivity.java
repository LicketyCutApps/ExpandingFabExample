/*
 * Copyright 2019 Adam Claflin [adam.r.claflin@gmail.com].
 *
 * Licensed under the Attribution-NonCommercial 4.0 International (CC BY-NC 4.0);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://creativecommons.org/licenses/by-nc/4.0/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.licketycut.expandingfabexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Activity to demonstrate {@link ExpandingFab} class.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ExpandingFabExample";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Provide user with a back button to exit.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Create our expanding fab group using the current view group, the + button,
        // primary color background and white foreground.
        final ExpandingFab expandingFab = new ExpandingFab(this,
                (ViewGroup) findViewById(android.R.id.content), android.R.drawable.ic_input_add,
                getResources().getColor(R.color.colorPrimary), Color.WHITE);

        // Add our listener for open/close events.
        expandingFab.onOpenCloseListener(new ExpandingFab.ExpandingFabListener() {
            @Override
            public void onOpen(ArrayList<FloatingActionButton> fabs) {
                Toast.makeText(getBaseContext(), "Expanding Fab opened.",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onClose(ArrayList<FloatingActionButton> fabs) {
                Toast.makeText(getBaseContext(), "Expanding Fab closed.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Add search fab with default colors and generate the on click listener.
        expandingFab.newFab(
                android.R.drawable.ic_search_category_default, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getBaseContext(), "Search Fab clicked.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

        // Add save fab with save color resource background, white foreground
        // and generate the on click listener.
         expandingFab.newFab(android.R.drawable.ic_menu_save,
                getResources().getColor(R.color.saveColor), Color.WHITE,
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getBaseContext(), "Save Fab clicked.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

        // Add share fab with share color resource background and white foreground.
        FloatingActionButton shareFab = expandingFab.newFab(android.R.drawable.ic_menu_share,
                getResources().getColor(R.color.shareColor), Color.WHITE);

        // Add on click listener to the share fab.
        shareFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Share Fab clicked.",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
