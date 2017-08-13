package package com.ankamagames.dofus.network.messages.game.context.roleplay.havenbag.meeting;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class InviteInHavenBagClosedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6645;
    private boolean _isInitialized = false;
    private CharacterMinimalInformations hostInformations = ;
    private FuncTree _hostInformationstree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6645;
    }

    public InviteInHavenBagClosedMessage initInviteInHavenBagClosedMessage(CharacterMinimalInformations param1) {
         this.hostInformations = param1;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.hostInformations = new CharacterMinimalInformations();
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
         this.serializeAs_InviteInHavenBagClosedMessage(param1);
    }

    public void serializeAs_InviteInHavenBagClosedMessage(ICustomDataOutput param1) {
         this.hostInformations.serializeAs_CharacterMinimalInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_InviteInHavenBagClosedMessage(param1);
    }

    public void deserializeAs_InviteInHavenBagClosedMessage(ICustomDataInput param1) {
         this.hostInformations = new CharacterMinimalInformations();
         this.hostInformations.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_InviteInHavenBagClosedMessage(param1);
    }

    public void deserializeAsyncAs_InviteInHavenBagClosedMessage(FuncTree param1) {
         this._hostInformationstree = param1.addChild(this._hostInformationstreeFunc);
    }

    private void _hostInformationstreeFunc(ICustomDataInput param1) {
         this.hostInformations = new CharacterMinimalInformations();
         this.hostInformations.deserializeAsync(this._hostInformationstree);
    }

}