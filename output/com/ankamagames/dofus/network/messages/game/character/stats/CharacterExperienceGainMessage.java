package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class CharacterExperienceGainMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6321;
    private boolean _isInitialized = false;
    private Number experienceCharacter = 0;
    private Number experienceMount = 0;
    private Number experienceGuild = 0;
    private Number experienceIncarnation = 0;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6321;
    }

    public CharacterExperienceGainMessage initCharacterExperienceGainMessage(Number param1,Number  param2,Number  param3,Number  param4) {
         this.experienceCharacter = param1;
         this.experienceMount = param2;
         this.experienceGuild = param3;
         this.experienceIncarnation = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.experienceCharacter = 0;
         this.experienceMount = 0;
         this.experienceGuild = 0;
         this.experienceIncarnation = 0;
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
         this.serializeAs_CharacterExperienceGainMessage(param1);
    }

    public void serializeAs_CharacterExperienceGainMessage(ICustomDataOutput param1) {
         if(this.experienceCharacter < 0 || this.experienceCharacter > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceCharacter + ") on element experienceCharacter.");
         }
         param1.writeVarLong(this.experienceCharacter);
         if(this.experienceMount < 0 || this.experienceMount > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceMount + ") on element experienceMount.");
         }
         param1.writeVarLong(this.experienceMount);
         if(this.experienceGuild < 0 || this.experienceGuild > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceGuild + ") on element experienceGuild.");
         }
         param1.writeVarLong(this.experienceGuild);
         if(this.experienceIncarnation < 0 || this.experienceIncarnation > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceIncarnation + ") on element experienceIncarnation.");
         }
         param1.writeVarLong(this.experienceIncarnation);
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_CharacterExperienceGainMessage(param1);
    }

    public void deserializeAs_CharacterExperienceGainMessage(ICustomDataInput param1) {
         this._experienceCharacterFunc(param1);
         this._experienceMountFunc(param1);
         this._experienceGuildFunc(param1);
         this._experienceIncarnationFunc(param1);
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_CharacterExperienceGainMessage(param1);
    }

    public void deserializeAsyncAs_CharacterExperienceGainMessage(FuncTree param1) {
         param1.addChild(this._experienceCharacterFunc);
         param1.addChild(this._experienceMountFunc);
         param1.addChild(this._experienceGuildFunc);
         param1.addChild(this._experienceIncarnationFunc);
    }

    private void _experienceCharacterFunc(ICustomDataInput param1) {
         this.experienceCharacter = param1.readVarUhLong();
         if(this.experienceCharacter < 0 || this.experienceCharacter > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceCharacter + ") on element of CharacterExperienceGainMessage.experienceCharacter.");
         }
    }

    private void _experienceMountFunc(ICustomDataInput param1) {
         this.experienceMount = param1.readVarUhLong();
         if(this.experienceMount < 0 || this.experienceMount > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceMount + ") on element of CharacterExperienceGainMessage.experienceMount.");
         }
    }

    private void _experienceGuildFunc(ICustomDataInput param1) {
         this.experienceGuild = param1.readVarUhLong();
         if(this.experienceGuild < 0 || this.experienceGuild > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceGuild + ") on element of CharacterExperienceGainMessage.experienceGuild.");
         }
    }

    private void _experienceIncarnationFunc(ICustomDataInput param1) {
         this.experienceIncarnation = param1.readVarUhLong();
         if(this.experienceIncarnation < 0 || this.experienceIncarnation > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceIncarnation + ") on element of CharacterExperienceGainMessage.experienceIncarnation.");
         }
    }

}