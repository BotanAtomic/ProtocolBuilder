package package com.ankamagames.dofus.network.messages.game.guild.tax;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalPlusLookInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;

public class GuildFightPlayersHelpersJoinMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 5720;
    private boolean _isInitialized = false;
    private int fightId = 0;
    private CharacterMinimalPlusLookInformations playerInfo = ;
    private FuncTree _playerInfotree = ;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 5720;
    }

    public GuildFightPlayersHelpersJoinMessage initGuildFightPlayersHelpersJoinMessage(int param1,CharacterMinimalPlusLookInformations  param2) {
         this.fightId = param1;
         this.playerInfo = param2;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.fightId = 0;
         this.playerInfo = new CharacterMinimalPlusLookInformations();
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
         this.serializeAs_GuildFightPlayersHelpersJoinMessage(param1);
    }

    public void serializeAs_GuildFightPlayersHelpersJoinMessage(ICustomDataOutput param1) {
         if(this.fightId < 0)
            throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildFightPlayersHelpersJoinMessage(param1);
    }

    public void deserializeAs_GuildFightPlayersHelpersJoinMessage(ICustomDataInput param1) {
         this._fightIdFunc(param1);
         this.playerInfo = new CharacterMinimalPlusLookInformations();
         this.playerInfo.deserialize(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildFightPlayersHelpersJoinMessage(param1);
    }

    public void deserializeAsyncAs_GuildFightPlayersHelpersJoinMessage(FuncTree param1) {
         param1.addChild(this._fightIdFunc);
         this._playerInfotree = param1.addChild(this._playerInfotreeFunc);
    }

    private void _fightIdFunc(ICustomDataInput param1) {
         this.fightId = param1.readInt();
         if(this.fightId < 0)
            throw new Exception("Forbidden value (" + this.fightId + ") on element of GuildFightPlayersHelpersJoinMessage.fightId.");
    }

    private void _playerInfotreeFunc(ICustomDataInput param1) {
         this.playerInfo = new CharacterMinimalPlusLookInformations();
         this.playerInfo.deserializeAsync(this._playerInfotree);
    }

}