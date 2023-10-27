package io.github.ageuxo.void_cube;

public class VoidCubeBlockTransparent extends VoidCubeBlock{
    public VoidCubeBlockTransparent(Properties properties) {
        super(properties);
    }

    @Override
    public boolean shouldRenderOverlay() {
        return false;
    }
}
