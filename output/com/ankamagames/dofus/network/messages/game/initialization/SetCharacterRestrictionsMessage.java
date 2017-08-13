package com.ankamagames.dofus.network.messages.game.initialization;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.restriction.ActorRestrictionsInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class SetCharacterRestrictionsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 170;
    private boolean _isInitialized = false;
    private Number actorId = 0;
    private ActorRestrictionsInformations restrictions;
    private FuncTree _restrictionstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 170;
    }

    public SetCharacterRestrictionsMessage initSetCharacterRestrictionsMessage(Number param1,ActorRestrictionsInformations  param2) {
         this.actorId = param1;
         this.restrictions = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.actorId = 0;
         this.restrictions = new ActorRestrictionsInformations();
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
         this.serializeAs_SetCharacterRestrictionsMessage(param1);
    }

    public void serializeAs_SetCharacterRestrictionsMessage(ICustomDataOutput param1) {
         if(this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.actorId + ") on element actorId.");
         }
         param1.writeDouble(this.actorId);
         this.restrictions.serializeAs_ActorRestrictionsInformations(param1);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_SetCharacterRestrictionsMessage(param1);
    }

    public void deserializeAs_SetCharacterRestrictionsMessage(ICustomDataInput param1) {
         this._actorIdFunc(param1);
         this.restrictions = new ActorRestrictionsInformations();
         this.restrictions.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_SetCharacterRestrictionsMessage(param1);
    }

    public void deserializeAsyncAs_SetCharacterRestrictionsMessage(FuncTree param1) {
         param1.addChild(this._actorIdFunc);
         this._restrictionstree = param1.addChild(this._restrictionstreeFunc);
    }

    private void _actorIdFunc(ICustomDataInput param1) {
         this.actorId = param1.readDouble();
         if(this.actorId < -9.007199254740992E15 || this.actorId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.actorId + ") on element of SetCharacterRestrictionsMessage.actorId.");
         }
    }

    private void _restrictionstreeFunc(ICustomDataInput param1) {
         this.restrictions = new ActorRestrictionsInformations();
         this.restrictions.deserializeAsync(this._restrictionstree);
    }

}