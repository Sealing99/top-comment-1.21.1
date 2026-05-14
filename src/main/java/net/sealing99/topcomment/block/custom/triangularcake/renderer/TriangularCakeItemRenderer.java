package net.sealing99.topcomment.block.custom.triangularcake.renderer;


import net.sealing99.topcomment.block.custom.triangularcake.item.TriangularCakeBlockItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TriangularCakeItemRenderer extends GeoItemRenderer<TriangularCakeBlockItem> {
    public TriangularCakeItemRenderer() {
        super(new TriangularCakeItemModel());
    }
}

