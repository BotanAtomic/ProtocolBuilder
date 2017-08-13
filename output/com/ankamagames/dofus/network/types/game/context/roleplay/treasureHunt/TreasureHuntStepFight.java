package package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class TreasureHuntStepFight extends TreasureHuntStep implements INetworkType {

    private int protocolId = 462;


    public int getTypeId() {
         return 462;
    }

    public TreasureHuntStepFight initTreasureHuntStepFight() {
         return this;
    }

    public void reset() {
    }

    public void serialize(ICustomDataOutput param1) {
    }

    public void serializeAs_TreasureHuntStepFight(ICustomDataOutput param1) {
    }

    public void deserialize(ICustomDataInput param1) {
    }

    public void deserializeAs_TreasureHuntStepFight(ICustomDataInput param1) {
    }

    public void deserializeAsync(FuncTree param1) {
    }

    public void deserializeAsyncAs_TreasureHuntStepFight(FuncTree param1) {
    }

}