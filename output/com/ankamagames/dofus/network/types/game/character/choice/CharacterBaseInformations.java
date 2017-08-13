package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.dofus.network.types.game.look.EntityLook;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterBaseInformations extends CharacterMinimalPlusLookInformations implements INetworkType {

    private int protocolId = 45;
    private int breed = 0;
    private boolean sex = false;


    public int getTypeId() {
         return 45;
    }

    public CharacterBaseInformations initCharacterBaseInformations(Number param1,String  param2,int  param3,EntityLook  param4,int  param5,boolean  param6) {
         super.initCharacterMinimalPlusLookInformations(param1,param2,param3,param4);
         this.breed = param5;
         this.sex = param6;
         return this;
    }

    public void reset() {
         super.reset();
         this.breed = 0;
         this.sex = false;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterBaseInformations(param1);
    }

    public void serializeAs_CharacterBaseInformations(ICustomDataOutput param1) {
         super.serializeAs_CharacterMinimalPlusLookInformations(param1);
         param1.writeByte(this.breed);
         param1.writeBoolean(this.sex);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterBaseInformations(param1);
    }

    public void deserializeAs_CharacterBaseInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._breedFunc(param1);
         this._sexFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterBaseInformations(param1);
    }

    public void deserializeAsyncAs_CharacterBaseInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._breedFunc);
         param1.addChild(this._sexFunc);
    }

    private void _breedFunc(ICustomDataInput param1) {
         this.breed = param1.readByte();
    }

    private void _sexFunc(ICustomDataInput param1) {
         this.sex = param1.readBoolean();
    }

}