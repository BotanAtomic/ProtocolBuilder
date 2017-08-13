package com.ankamagames.dofus.network.types.game.character;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterMinimalInformations extends CharacterBasicMinimalInformations implements INetworkType {

    private int protocolId = 110;
    private int level = 0;


    public int getTypeId() {
         return 110;
    }

    public CharacterMinimalInformations initCharacterMinimalInformations(Number param1,String  param2,int  param3) {
         super.initCharacterBasicMinimalInformations(param1,param2);
         this.level = param3;
         return this;
    }

    public void reset() {
         super.reset();
         this.level = 0;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterMinimalInformations(param1);
    }

    public void serializeAs_CharacterMinimalInformations(ICustomDataOutput param1) {
         super.serializeAs_CharacterBasicMinimalInformations(param1);
         if(this.level < 1 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element level.");
         }
         param1.writeByte(this.level);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterMinimalInformations(param1);
    }

    public void deserializeAs_CharacterMinimalInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._levelFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterMinimalInformations(param1);
    }

    public void deserializeAsyncAs_CharacterMinimalInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._levelFunc);
    }

    private void _levelFunc(ICustomDataInput param1) {
         this.level = param1.readUnsignedByte();
         if(this.level < 1 || this.level > 206)
         {
            throw new Exception("Forbidden value (" + this.level + ") on element of CharacterMinimalInformations.level.");
         }
    }

}