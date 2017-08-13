package package com.ankamagames.dofus.network.types.game.character;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AbstractCharacterInformation extends Object implements INetworkType {

    private int protocolId = 400;
    private Number id = 0;


    public int getTypeId() {
         return 400;
    }

    public AbstractCharacterInformation initAbstractCharacterInformation(Number param1) {
         this.id = param1;
         return this;
    }

    public void reset() {
         this.id = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_AbstractCharacterInformation(param1);
    }

    public void serializeAs_AbstractCharacterInformation(ICustomDataOutput param1) {
         if(this.id < 0 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element id.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AbstractCharacterInformation(param1);
    }

    public void deserializeAs_AbstractCharacterInformation(ICustomDataInput param1) {
         this._idFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AbstractCharacterInformation(param1);
    }

    public void deserializeAsyncAs_AbstractCharacterInformation(FuncTree param1) {
         param1.addChild(this._idFunc);
    }

    private void _idFunc(ICustomDataInput param1) {
         this.id = param1.readVarUhLong();
         if(this.id < 0 || this.id > 9.007199254740992E15)
            throw new Exception("Forbidden value (" + this.id + ") on element of AbstractCharacterInformation.id.");
    }

}