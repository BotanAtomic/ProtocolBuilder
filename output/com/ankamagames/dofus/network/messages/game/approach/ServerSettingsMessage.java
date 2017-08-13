package package com.ankamagames.dofus.network.messages.game.approach;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class ServerSettingsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6340;
    private boolean _isInitialized = false;
    private String lang = "";
    private int community = 0;
    private int gameType = -1;
    private int arenaLeaveBanTime = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6340;
    }

    public ServerSettingsMessage initServerSettingsMessage(String param1,int  param2,int  param3,int  param4) {
         this.lang = param1;
         this.community = param2;
         this.gameType = param3;
         this.arenaLeaveBanTime = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.lang = "";
         this.community = 0;
         this.gameType = -1;
         this.arenaLeaveBanTime = 0;
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
         this.serializeAs_ServerSettingsMessage(param1);
    }

    public void serializeAs_ServerSettingsMessage(ICustomDataOutput param1) {
         param1.writeUTF(this.lang);
         if(this.community < 0)
            throw new Exception("Forbidden value (" + this.community + ") on element community.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_ServerSettingsMessage(param1);
    }

    public void deserializeAs_ServerSettingsMessage(ICustomDataInput param1) {
         this._langFunc(param1);
         this._communityFunc(param1);
         this._gameTypeFunc(param1);
         this._arenaLeaveBanTimeFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_ServerSettingsMessage(param1);
    }

    public void deserializeAsyncAs_ServerSettingsMessage(FuncTree param1) {
         param1.addChild(this._langFunc);
         param1.addChild(this._communityFunc);
         param1.addChild(this._gameTypeFunc);
         param1.addChild(this._arenaLeaveBanTimeFunc);
    }

    private void _langFunc(ICustomDataInput param1) {
         this.lang = param1.readUTF();
    }

    private void _communityFunc(ICustomDataInput param1) {
         this.community = param1.readByte();
         if(this.community < 0)
            throw new Exception("Forbidden value (" + this.community + ") on element of ServerSettingsMessage.community.");
    }

    private void _gameTypeFunc(ICustomDataInput param1) {
         this.gameType = param1.readByte();
    }

    private void _arenaLeaveBanTimeFunc(ICustomDataInput param1) {
         this.arenaLeaveBanTime = param1.readVarUhShort();
         if(this.arenaLeaveBanTime < 0)
            throw new Exception("Forbidden value (" + this.arenaLeaveBanTime + ") on element of ServerSettingsMessage.arenaLeaveBanTime.");
    }

}