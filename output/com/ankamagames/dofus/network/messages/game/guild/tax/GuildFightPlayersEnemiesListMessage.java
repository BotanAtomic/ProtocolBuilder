package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildFightPlayersEnemiesListMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5928;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private Vector<CharacterMinimalPlusLookInformations> playerInfo;
    private FuncTree _playerInfotree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5928;
    }

    public GuildFightPlayersEnemiesListMessage initGuildFightPlayersEnemiesListMessage(int param1,Vector<CharacterMinimalPlusLookInformations>  param2) {
         this.fightId = param1;
         this.playerInfo = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightId = 0;
         this.playerInfo = new Vector.<CharacterMinimalPlusLookInformations>();
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
         this.serializeAs_GuildFightPlayersEnemiesListMessage(param1);
    }

    public void serializeAs_GuildFightPlayersEnemiesListMessage(ICustomDataOutput param1) {
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
         }
         param1.writeInt(this.fightId);
         param1.writeShort(this.playerInfo.length);
         int _loc2_ = 0;
         while(_loc2_ < this.playerInfo.length)
         {
            (this.playerInfo[_loc2_] as CharacterMinimalPlusLookInformations).serializeAs_CharacterMinimalPlusLookInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildFightPlayersEnemiesListMessage(param1);
    }

    public void deserializeAs_GuildFightPlayersEnemiesListMessage(ICustomDataInput param1) {
         CharacterMinimalPlusLookInformations _loc4_ = null;
         this._fightIdFunc(param1);
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new CharacterMinimalPlusLookInformations();
            _loc4_.deserialize(param1);
            this.playerInfo.push(_loc4_);
            _loc3_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildFightPlayersEnemiesListMessage(param1);
    }

    public void deserializeAsyncAs_GuildFightPlayersEnemiesListMessage(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
         this._playerInfotree = param1.addChild(this._playerInfotreeFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
         if(this.fightId < 0)
         {
            throw new Exception("Forbidden value (" + this.fightId + ") on element of GuildFightPlayersEnemiesListMessage.fightId.");
         }
    }

    private void _playerInfotreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._playerInfotree.addChild(this._playerInfoFunc);
            _loc3_++;
         }
    }

    private void _playerInfoFunc(ICustomDataInput param1) {
         CharacterMinimalPlusLookInformations _loc2_ = new CharacterMinimalPlusLookInformations();
         _loc2_.deserialize(param1);
         this.playerInfo.push(_loc2_);
    }

}