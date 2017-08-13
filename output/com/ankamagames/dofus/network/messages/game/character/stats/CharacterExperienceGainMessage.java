package com.ankamagames.dofus.network.messages.game.character.stats;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import java.lang.Exception;

public class CharacterExperienceGainMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6321;
    private boolean _isInitialized = false;
    private Number experienceCharacter = 0;
    private Number experienceMount = 0;
    private Number experienceGuild = 0;
    private Number experienceIncarnation = 0;


    public void serialize(ICustomDataOutput param1) {
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
         this.experienceCharacter = param1.readVarUhLong();
         if(this.experienceCharacter < 0 || this.experienceCharacter > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceCharacter + ") on element of CharacterExperienceGainMessage.experienceCharacter.");
         }
         this.experienceMount = param1.readVarUhLong();
         if(this.experienceMount < 0 || this.experienceMount > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceMount + ") on element of CharacterExperienceGainMessage.experienceMount.");
         }
         this.experienceGuild = param1.readVarUhLong();
         if(this.experienceGuild < 0 || this.experienceGuild > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceGuild + ") on element of CharacterExperienceGainMessage.experienceGuild.");
         }
         this.experienceIncarnation = param1.readVarUhLong();
         if(this.experienceIncarnation < 0 || this.experienceIncarnation > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.experienceIncarnation + ") on element of CharacterExperienceGainMessage.experienceIncarnation.");
         }
    }

}