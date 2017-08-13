package package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TreasureHuntStepDig extends TreasureHuntStep implements INetworkType {

    private int protocolId = 465;


    public int getTypeId() {
         return 465;
    }

    public TreasureHuntStepDig initTreasureHuntStepDig() {
         return this;
    }

    public void reset() {
    }

    public void serialize(ICustomDataOutput param1) {
    }

    public void serializeAs_TreasureHuntStepDig(ICustomDataOutput param1) {
    }

    public void deserialize(ICustomDataInput param1) {
    }

    public void deserializeAs_TreasureHuntStepDig(ICustomDataInput param1) {
    }

    public void deserializeAsync(FuncTree param1) {
    }

    public void deserializeAsyncAs_TreasureHuntStepDig(FuncTree param1) {
    }

}