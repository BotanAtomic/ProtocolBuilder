package package com.ankamagames.dofus.network.types.game.context.roleplay;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class HumanOptionOrnament extends HumanOption implements INetworkType {

    private int protocolId = 411;
    private int ornamentId = 0;


    public int getTypeId() {
         return 411;
    }

    public HumanOptionOrnament initHumanOptionOrnament(int param1) {
         this.ornamentId = param1;
         return this;
    }

    public void reset() {
         this.ornamentId = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_HumanOptionOrnament(param1);
    }

    public void serializeAs_HumanOptionOrnament(ICustomDataOutput param1) {
         super.serializeAs_HumanOption(param1);
         if(this.ornamentId < 0)
            throw new Exception("Forbidden value (" + this.ornamentId + ") on element ornamentId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_HumanOptionOrnament(param1);
    }

    public void deserializeAs_HumanOptionOrnament(ICustomDataInput param1) {
         super.deserialize(param1);
         this._ornamentIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_HumanOptionOrnament(param1);
    }

    public void deserializeAsyncAs_HumanOptionOrnament(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._ornamentIdFunc);
    }

    private void _ornamentIdFunc(ICustomDataInput param1) {
         this.ornamentId = param1.readVarUhShort();
         if(this.ornamentId < 0)
            throw new Exception("Forbidden value (" + this.ornamentId + ") on element of HumanOptionOrnament.ornamentId.");
    }

}