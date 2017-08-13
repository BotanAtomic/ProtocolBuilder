package package com.ankamagames.dofus.network.types.game.character.choice;

import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharacterToRecolorInformation extends AbstractCharacterToRefurbishInformation implements INetworkType {

    private int protocolId = 212;


    public int getTypeId() {
         return 212;
    }

    public CharacterToRecolorInformation initCharacterToRecolorInformation(Number param1,Vector.<int>  param2,int  param3) {
         super.initAbstractCharacterToRefurbishInformation(param1,param2,param3);
         return this;
    }

    public void reset() {
         super.reset();
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharacterToRecolorInformation(param1);
    }

    public void serializeAs_CharacterToRecolorInformation(ICustomDataOutput param1) {
         super.serializeAs_AbstractCharacterToRefurbishInformation(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterToRecolorInformation(param1);
    }

    public void deserializeAs_CharacterToRecolorInformation(ICustomDataInput param1) {
         super.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterToRecolorInformation(param1);
    }

    public void deserializeAsyncAs_CharacterToRecolorInformation(FuncTree param1) {
         super.deserializeAsync(param1);
    }

}