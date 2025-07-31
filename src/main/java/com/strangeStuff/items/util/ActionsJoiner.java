package com.strangeStuff.items.util;

import com.google.common.collect.Sets;
import net.minecraftforge.common.ToolAction;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.minecraftforge.common.ToolActions.*;

public class ActionsJoiner {
    private static Set<ToolAction> join(ToolAction... actions) {
        return Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    }

    public static final Set<ToolAction> DRILL_ACTIONS = join(PICKAXE_DIG, SHOVEL_DIG, AXE_DIG, HOE_DIG);
}
