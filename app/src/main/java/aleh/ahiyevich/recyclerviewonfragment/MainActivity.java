package aleh.ahiyevich.recyclerviewonfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment(FirstFragment.newInstance());

    }

    private void initFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_for_fragment, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        initFragment(FirstFragment.newInstance());
    }


}