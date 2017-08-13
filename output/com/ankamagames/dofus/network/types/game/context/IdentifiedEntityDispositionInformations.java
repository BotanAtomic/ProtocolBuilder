package package com.ankamagames.dofus.network.types.game.context;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class IdentifiedEntityDispositionInformations extends EntityDispositionInformations implements INetworkType {

    private int protocolId = 107;
    private Number id = 0;


    public int getTypeId() {
         return 107;
    }

    public IdentifiedEntityDispositionInformations initIdentifiedEntityDispositionInformations(int param1,int  param2,Number  param3) {
         super.initEntityDispositionInformations(param1,param2);
         this.id = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.id = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_IdentifiedEntityDispositionInformations(param1);
    }

    public void serializeAs_IdentifiedEntityDispositionInformations(ICustomDataOutput param1) {
         super.serializeAs_EntityDispositionInformations(param1);
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_IdentifiedEntityDispositionInformations(param1);
    }

    public void deserializeAs_IdentifiedEntityDispositionInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._idFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_IdentifiedEntityDispositionInformations(param1);
    }

    public void deserializeAsyncAs_IdentifiedEntityDispositionInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._idFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readDouble();
         if(this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element of IdentifiedEntityDispositionInformations.id.");
    }

}