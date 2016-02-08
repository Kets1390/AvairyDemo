package ntechnosoft.com.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.aviary.android.feather.sdk.AviaryIntent;

/**
 * Created by Ketan on 2/8/2016.
 */
public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
         imageView= (ImageView) findViewById(R.id.imageView);
imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, 1);
    }
});


    /* 2) Create a new Intent */

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==1 && resultCode==RESULT_OK && null!=data) {

            //Uri imageUri = Uri.parse("http://my-site-ftw.com/sweet-sweet-image.jpg");
            Uri imageUri = data.getData();
            Intent imageEditorIntent = new AviaryIntent.Builder(this)
                    .setData(imageUri)
                    .build();

    /* 3) Start the Image Editor with request code 1 */
            startActivityForResult(imageEditorIntent, 2);
        }
        else if(requestCode==2 && resultCode==RESULT_OK && null!=data)
        {
            imageView.setImageURI(data.getData());
        }
    }
}
