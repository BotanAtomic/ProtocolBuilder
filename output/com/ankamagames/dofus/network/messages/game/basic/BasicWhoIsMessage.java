package com.ankamagames.dofus.network.messages.game.basic;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.social.AbstractSocialGroupInfos;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.jerakine.network.utils.BooleanByteWrapper;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class BasicWhoIsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 180;
    private boolean _isInitialized = false;
    private boolean self = false;
    private int position = -1;
    private String accountNickname = "";
    private int accountId = 0;
    private String playerName = "";
    private Number playerId = 0;
    private int areaId = 0;
    private int serverId = 0;
    private int originServerId = 0;
    private Vector<AbstractSocialGroupInfos> socialGroups;
    private boolean verbose = false;
    private int playerState = 99;
    private FuncTree _socialGroupstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 180;
    }

    public BasicWhoIsMessage initBasicWhoIsMessage(boolean param1,int  param2,String  param3,int  param4,String  param5,Number  param6,int  param7,int  param8,int  param9,Vector<AbstractSocialGroupInfos>  param10,boolean  param11,int  param12) {
         this.self = param1;
         this.position = param2;
         this.accountNickname = param3;
         this.accountId = param4;
         this.playerName = param5;
         this.playerId = param6;
         this.areaId = param7;
         this.serverId = param8;
         this.originServerId = param9;
         this.socialGroups = param10;
         this.verbose = param11;
         this.playerState = param12;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.self = false;
         this.position = -1;
         this.accountNickname = "";
         this.accountId = 0;
         this.playerName = "";
         this.playerId = 0;
         this.areaId = 0;
         this.serverId = 0;
         this.originServerId = 0;
         this.socialGroups = new Vector.<AbstractSocialGroupInfos>();
         this.verbose = false;
         this.playerState = 99;
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
         this.serializeAs_BasicWhoIsMessage(param1);
    }

    public void serializeAs_BasicWhoIsMessage(ICustomDataOutput param1) {
         int _loc2_ = 0;
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,0,this.self);
         _loc2_ = BooleanByteWrapper.setFlag(_loc2_,1,this.verbose);
         param1.writeByte(_loc2_);
         param1.writeByte(this.position);
         param1.writeUTF(this.accountNickname);
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element accountId.");
         }
         param1.writeInt(this.accountId);
         param1.writeUTF(this.playerName);
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element playerId.");
         }
         param1.writeVarLong(this.playerId);
         param1.writeShort(this.areaId);
         param1.writeShort(this.serverId);
         param1.writeShort(this.originServerId);
         param1.writeShort(this.socialGroups.length);
         int _loc3_ = 0;
         while(_loc3_ < this.socialGroups.length)
         {
            param1.writeShort((this.socialGroups[_loc3_] as AbstractSocialGroupInfos).getTypeId());
            (this.socialGroups[_loc3_] as AbstractSocialGroupInfos).serialize(param1);
            _loc3_++;
         }
         param1.writeByte(this.playerState);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_BasicWhoIsMessage(param1);
    }

    public void deserializeAs_BasicWhoIsMessage(ICustomDataInput param1) {
         int _loc4_ = 0;
         AbstractSocialGroupInfos _loc5_ = null;
         this.deserializeByteBoxes(param1);
         this._positionFunc(param1);
         this._accountNicknameFunc(param1);
         this._accountIdFunc(param1);
         this._playerNameFunc(param1);
         this._playerIdFunc(param1);
         this._areaIdFunc(param1);
         this._serverIdFunc(param1);
         this._originServerIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(AbstractSocialGroupInfos,_loc4_);
            _loc5_.deserialize(param1);
            this.socialGroups.push(_loc5_);
            _loc3_++;
         }
         this._playerStateFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_BasicWhoIsMessage(param1);
    }

    public void deserializeAsyncAs_BasicWhoIsMessage(FuncTree param1) {
         param1.addChild(this.deserializeByteBoxes);
         param1.addChild(this._positionFunc);
         param1.addChild(this._accountNicknameFunc);
         param1.addChild(this._accountIdFunc);
         param1.addChild(this._playerNameFunc);
         param1.addChild(this._playerIdFunc);
         param1.addChild(this._areaIdFunc);
         param1.addChild(this._serverIdFunc);
         param1.addChild(this._originServerIdFunc);
         this._socialGroupstree = param1.addChild(this._socialGroupstreeFunc);
         param1.addChild(this._playerStateFunc);
    }

    private void deserializeByteBoxes(ICustomDataInput param1) {
         int _loc2_ = param1.readByte();
         this.self = BooleanByteWrapper.getFlag(_loc2_,0);
         this.verbose = BooleanByteWrapper.getFlag(_loc2_,1);
    }

    private void _positionFunc(ICustomDataInput param1) {
         this.position = param1.readByte();
    }

    private void _accountNicknameFunc(ICustomDataInput param1) {
         this.accountNickname = param1.readUTF();
    }

    private void _accountIdFunc(ICustomDataInput param1) {
         this.accountId = param1.readInt();
         if(this.accountId < 0)
         {
            throw new Exception("Forbidden value (" + this.accountId + ") on element of BasicWhoIsMessage.accountId.");
         }
    }

    private void _playerNameFunc(ICustomDataInput param1) {
         this.playerName = param1.readUTF();
    }

    private void _playerIdFunc(ICustomDataInput param1) {
         this.playerId = param1.readVarUhLong();
         if(this.playerId < 0 || this.playerId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.playerId + ") on element of BasicWhoIsMessage.playerId.");
         }
    }

    private void _areaIdFunc(ICustomDataInput param1) {
         this.areaId = param1.readShort();
    }

    private void _serverIdFunc(ICustomDataInput param1) {
         this.serverId = param1.readShort();
    }

    private void _originServerIdFunc(ICustomDataInput param1) {
         this.originServerId = param1.readShort();
    }

    private void _socialGroupstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._socialGroupstree.addChild(this._socialGroupsFunc);
            _loc3_++;
         }
    }

    private void _socialGroupsFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         AbstractSocialGroupInfos _loc3_ = ProtocolTypeManager.getInstance(AbstractSocialGroupInfos,_loc2_);
         _loc3_.deserialize(param1);
         this.socialGroups.push(_loc3_);
    }

    private void _playerStateFunc(ICustomDataInput param1) {
         this.playerState = param1.readByte();
         if(this.playerState < 0)
         {
            throw new Exception("Forbidden value (" + this.playerState + ") on element of BasicWhoIsMessage.playerState.");
         }
    }

}