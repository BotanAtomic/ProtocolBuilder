package com.ankamagames.dofus.network.types.game.context.roleplay.treasureHunt;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class TreasureHuntFlag extends Object implements INetworkType {

    private int protocolId = 473;
    private int mapId = 0;
    private int state = 0;


    public int getTypeId() {
         return 473;
    }

    public TreasureHuntFlag initTreasureHuntFlag(int param1,int  param2) {
         this.mapId = param1;
         this.state = param2;
         return this;
    }

    public void reset() {
         this.mapId = 0;
         this.state = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_TreasureHuntFlag(param1);
    }

    public void serializeAs_TreasureHuntFlag(ICustomDataOutput param1) {
         param1.writeInt(this.mapId);
         param1.writeByte(this.state);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_TreasureHuntFlag(param1);
    }

    public void deserializeAs_TreasureHuntFlag(ICustomDataInput param1) {
         this._mapIdFunc(param1);
         this._stateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_TreasureHuntFlag(param1);
    }

    public void deserializeAsyncAs_TreasureHuntFlag(FuncTree param1) {
         param1.addChild(this._mapIdFunc);
         param1.addChild(this._stateFunc);
    }

    private void _mapIdFunc(ICustomDataInput param1) {
         this.mapId = param1.readInt();
    }

    private void _stateFunc(ICustomDataInput param1) {
         this.state = param1.readByte();
         if(this.state < 0)
         {
            throw new Exception("Forbidden value (" + this.state + ") on element of TreasureHuntFlag.state.");
         }
    }

}