package com.example.project1;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.Frame;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.core.Session;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

/**
 * This is an example activity that uses the Sceneform UX package to make common AR tasks easier.
 */
@SuppressLint("Registered")
public class  directions_toll_periyar extends AppCompatActivity {
    private static final String TAG = directions_toll_periyar.class.getSimpleName();
    private static final double MIN_OPENGL_VERSION = 3.0;

    private ArFragment arFragment;
    private ModelRenderable andyRenderable;

    @Override
    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
    // CompletableFuture requires api level 24
    // FutureReturnValueIgnored is not valid
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!checkIsSupportedDeviceOrFinish(this)) {
            return;
        }

        setContentView(R.layout.activity_directions_toll_periyar);
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);

        // When you build a Renderable, Sceneform loads its resources in the background while returning
        // a CompletableFuture. Call thenAccept(), handle(), or check isDone() before calling get().
        ModelRenderable.builder()
                .setSource(this, R.raw.andy)
                .build()
                .thenAccept(renderable -> andyRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast =
                                    Toast.makeText(this, "Unable to load andy renderable", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        });
        final int[] flag = {0};
        arFragment.setOnTapArPlaneListener(
                (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
                    if (andyRenderable == null) {
                        return;
                    }
                    if(flag[0] ==0) {
                        flag[0] =1;
                        // Create the Anchor.
                        Anchor anchor = hitResult.createAnchor();
                        AnchorNode anchorNode = new AnchorNode(anchor);
                        anchorNode.setParent(arFragment.getArSceneView().getScene());

                        //anchorNode2.setLocalPosition(new Vector3(0.2f, 0.02f, 0.0f));

                        Frame frame;
                        Session session;

                        // Create the transformable andy and add it to the anchor.
                        TransformableNode andy = new TransformableNode(arFragment.getTransformationSystem());
                        andy.setRenderable(andyRenderable);
                        andy.getScaleController().setMinScale(2.0f);
                        andy.getScaleController().setMaxScale(3.0f);
                        andy.setLocalScale(new Vector3(2.0f, 2.0f, 2.0f));
                        andy.getTranslationController().setEnabled(false);
                        andy.getRotationController().setEnabled(false);
                        andy.setParent(anchorNode);
                        andy.select();

                        /* *****forward is z-axis, left/right is x-axis, up/down is y-axis****** */


                        int i;

                        for( i=1;i<26;i++)
                        {
                            Node andy2 = new Node();
                            andy2.setParent(andy);
                            andy2.setRenderable(andyRenderable);
                            andy2.setLocalPosition(new Vector3(0.0f, 0.0f, ((-1)*i)));
                        }

                        Node andy3 = new Node();
                        andy3.setParent(andy);
                        andy3.setRenderable(andyRenderable);
                        andy3.setLocalPosition(new Vector3(0.0f, 0.0f, -26f));

                        //till end of toll gate road

                        for( i=1;i<14;i++)
                        {
                            Node andy2 = new Node();
                            andy2.setParent(andy3);
                            andy2.setRenderable(andyRenderable);
                            andy2.setLocalPosition(new Vector3(((-1)*i), 0.0f,0.0f ));
                        }

                        Node andy4 = new Node();
                        andy4.setParent(andy3);
                        andy4.setRenderable(andyRenderable);
                        andy4.setLocalPosition(new Vector3(-14f, 0.5f, 0.0f));

                        for( i=1;i<4;i++)
                        {
                            Node andy2 = new Node();
                            andy2.setParent(andy4);
                            andy2.setRenderable(andyRenderable);
                            andy2.setLocalPosition(new Vector3(((-1)*i), 0.0f,0.0f ));
                        }


                    }//end of first tap 'if condition'
                });
    }

    /**
     * Returns false and displays an error message if Sceneform can not run, true if Sceneform can run
     * on this device.
     *
     * <p>Sceneform requires Android N on the device as well as OpenGL 3.0 capabilities.
     *
     * <p>Finishes the activity if Sceneform can not run
     */
    public static boolean checkIsSupportedDeviceOrFinish(final Activity activity) {
        if (Build.VERSION.SDK_INT < VERSION_CODES.N) {
            Log.e(TAG, "Sceneform requires Android N or later");
            Toast.makeText(activity, "Sceneform requires Android N or later", Toast.LENGTH_LONG).show();
            activity.finish();
            return false;
        }
        String openGlVersionString =
                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
                        .getDeviceConfigurationInfo()
                        .getGlEsVersion();
        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                    .show();
            activity.finish();
            return false;
        }
        return true;
    }
}
