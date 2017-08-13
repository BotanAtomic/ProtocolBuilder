package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharactersListMessage extends Basic {

    private int protocolId = 151;
    private boolean _isInitialized = false;
    private boolean hasStartupActions = false;


    public boolean isInitialized() {
         return super.isInitialized && this._isInitialized;
    }

    public int getMessageId() {
         return 151;
    }

    public CharactersListMessage initCharactersListMessage(Vector<CharacterBaseInformations> param1,boolean  param2) {
         super.initBasicCharactersListMessage(param1);
         this.hasStartupActions = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         super.reset();
         this.hasStartupActions = false;
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_CharactersListMessage(param1);
    }

    public void serializeAs_CharactersListMessage(ICustomDataOutput param1) {
         super.serializeAs_BasicCharactersListMessage(param1);
         param1.writeBoolean(this.hasStartupActions);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharactersListMessage(param1);
    }

    public void deserializeAs_CharactersListMessage(ICustomDataInput param1) {
         super.deserialize(param1);
         this._hasStartupActionsFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharactersListMessage(param1);
    }

    public void deserializeAsyncAs_CharactersListMessage(FuncTree param1) {
         super.deserializeAsync(param1);
         param1.addChild(this._hasStartupActionsFunc);
    }

    private void _hasStartupActionsFunc(ICustomDataInput param1) {
         this.hasStartupActions = param1.readBoolean();
    }

}