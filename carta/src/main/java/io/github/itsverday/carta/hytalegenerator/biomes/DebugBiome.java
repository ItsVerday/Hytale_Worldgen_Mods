package io.github.itsverday.carta.hytalegenerator.biomes;

import com.hypixel.hytale.builtin.hytalegenerator.PropRuntime;
import com.hypixel.hytale.builtin.hytalegenerator.biome.Biome;
import com.hypixel.hytale.builtin.hytalegenerator.density.Density;
import com.hypixel.hytale.builtin.hytalegenerator.density.nodes.BaseHeightDensity;
import com.hypixel.hytale.builtin.hytalegenerator.density.nodes.InverterDensity;
import com.hypixel.hytale.builtin.hytalegenerator.environmentproviders.EnvironmentProvider;
import com.hypixel.hytale.builtin.hytalegenerator.material.Material;
import com.hypixel.hytale.builtin.hytalegenerator.materialproviders.ConstantMaterialProvider;
import com.hypixel.hytale.builtin.hytalegenerator.materialproviders.MaterialProvider;
import com.hypixel.hytale.builtin.hytalegenerator.materialproviders.SolidityMaterialProvider;
import com.hypixel.hytale.builtin.hytalegenerator.tintproviders.TintProvider;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.List;
import java.util.function.Consumer;

public class DebugBiome implements Biome {
    private final Density density;
    private final MaterialProvider<Material> materialProvider;

    public DebugBiome(Material material) {
        density = new InverterDensity(new BaseHeightDensity(100, true));
        materialProvider = new SolidityMaterialProvider<>(new ConstantMaterialProvider<>(material), MaterialProvider.noMaterialProvider());
    }

    @NonNullDecl
    @Override
    public Density getTerrainDensity() {
        return density;
    }

    @Override
    public EnvironmentProvider getEnvironmentProvider() {
        return EnvironmentProvider.noEnvironmentProvider();
    }

    @Override
    public MaterialProvider<Material> getMaterialProvider() {
        return materialProvider;
    }

    @Override
    public void getRuntimesWithIndex(int i, @NonNullDecl Consumer<PropRuntime> consumer) {
    }

    @Override
    public List<PropRuntime> getPropRuntimes() {
        return List.of();
    }

    @Override
    public TintProvider getTintProvider() {
        return TintProvider.noTintProvider();
    }
}
