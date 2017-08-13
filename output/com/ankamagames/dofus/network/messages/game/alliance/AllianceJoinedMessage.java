package package com.ankamagames.dofus.network.messages.game.alliance;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.AllianceInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class AllianceJoinedMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6402;
    private boolean _isInitialized = false;
    private AllianceInformations allianceInfo = ;
    private boolean enabled = false;
    private int leadingGuildId = 0;
    private FuncTree _allianceInfotree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6402;
    }

    public AllianceJoinedMessage initAllianceJoinedMessage(AllianceInformations param1,boolean  param2,int  param3) {
         this.allianceInfo = param1;
         this.enabled = param2;
         this.leadingGuildId = param3;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.allianceInfo = new AllianceInformations();
         this.leadingGuildId = 0;
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
         this.serializeAs_AllianceJoinedMessage(param1);
    }

    public void serializeAs_AllianceJoinedMessage(ICustomDataOutput param1) {
         this.allianceInfo.serializeAs_AllianceInformations(param1);
         param1.writeBoolean(this.enabled);
         if(this.leadingGuildId < 0)
            throw new Exception("Forbidden value (" + this.leadingGuildId + ") on element leadingGuildId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_AllianceJoinedMessage(param1);
    }

    public void deserializeAs_AllianceJoinedMessage(ICustomDataInput param1) {
         this.allianceInfo = new AllianceInformations();
         this.allianceInfo.deserialize(param1);
         this._enabledFunc(param1);
         this._leadingGuildIdFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_AllianceJoinedMessage(param1);
    }

    public void deserializeAsyncAs_AllianceJoinedMessage(FuncTree param1) {
         this._allianceInfotree = param1.addChild(this._allianceInfotreeFunc);
         param1.addChild(this._enabledFunc);
         param1.addChild(this._leadingGuildIdFunc);
    }

    private void _allianceInfotreeFunc(ICustomDataInput param1) {
         this.allianceInfo = new AllianceInformations();
         this.allianceInfo.deserializeAsync(this._allianceInfotree);
    }

    private void _enabledFunc(ICustomDataInput param1) {
         this.enabled = param1.readBoolean();
    }

    private void _leadingGuildIdFunc(ICustomDataInput param1) {
         this.leadingGuildId = param1.readVarUhInt();
         if(this.leadingGuildId < 0)
            throw new Exception("Forbidden value (" + this.leadingGuildId + ") on element of AllianceJoinedMessage.leadingGuildId.");
    }

}