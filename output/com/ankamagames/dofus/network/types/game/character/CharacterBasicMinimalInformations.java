package package com.ankamagames.dofus.network.types.game.character;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterBasicMinimalInformations extends AbstractCharacterInformation implements INetworkType {

    private int protocolId = 503;
    private String name = "";


    public int getTypeId() {
         return 503;
    }

    public CharacterBasicMinimalInformations initCharacterBasicMinimalInformations(Number param1,String  param2) {
         super.initAbstractCharacterInformation(param1);
         this.name = param2;
         return this;
    }

    public void reset() {
         super.reset();
         this.name = "";
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterBasicMinimalInformations(param1);
    }

    public void serializeAs_CharacterBasicMinimalInformations(ICustomDataOutput param1) {
         super.serializeAs_AbstractCharacterInformation(param1);
         param1.writeUTF(this.name);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterBasicMinimalInformations(param1);
    }

    public void deserializeAs_CharacterBasicMinimalInformations(ICustomDataInput param1) {
         super.deserialize(param1);
         this._nameFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterBasicMinimalInformations(param1);
    }

    public void deserializeAsyncAs_CharacterBasicMinimalInformations(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._nameFunc);
    }

    private void _nameFunc(ICustomDataInput param1) {
         this.name = param1.readUTF();
    }

}